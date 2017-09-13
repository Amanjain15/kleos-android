package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.EditProfileCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.ProfileCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.ProfileRequestProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.EditProfileData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.view.ProfileRequestView;

/**
 * Created by aman on 11/9/17.
 */

public class ProfileRequestPresenterImpl implements ProfileRequestPresenter {

    private ProfileRequestView profileRequestView;
    private ProfileRequestProvider profileRequestProvider;

    public ProfileRequestPresenterImpl(ProfileRequestView profileRequestView,
                                       ProfileRequestProvider profileRequestProvider) {
        this.profileRequestView = profileRequestView;
        this.profileRequestProvider = profileRequestProvider;
    }

    @Override
    public void requestProfile(String access_token) {
        profileRequestView.showLoading(true);
        profileRequestProvider.requestProfile(access_token, new ProfileCallBack() {
            @Override
            public void onSuccess(ProfileRequestData profileRequestData) {
                try{
                    if (profileRequestData.isSuccess())
                    {
                        profileRequestView.showLoading(false);
                        profileRequestView.setData(profileRequestData);
                    }
                    else{
                        profileRequestView.showMessage(profileRequestData.getMessage());
                        profileRequestView.showLoading(false);
                    }
                }
                catch (NullPointerException e){

                    e.printStackTrace();
                    profileRequestView.showMessage("Success Null in Profile");
                    profileRequestView.showLoading(false);
                }
            }

            @Override
            public void onFailure(String e) {
                profileRequestView.showLoading(false);
                profileRequestView.showMessage(e);

            }
        });
    }

    @Override
    public void editProfile(String access_token, String name, String college, String email) {
        profileRequestView.showLoading(true);
        profileRequestView.enableSave(false);
        profileRequestProvider.editProfile(access_token, name, college, email, new EditProfileCallBack() {
            @Override
            public void onSuccess(EditProfileData editProfileData) {
                try{
                    if (editProfileData.isSuccess())
                    {
                        profileRequestView.showLoading(false);
                        profileRequestView.showMessage(editProfileData.getMessage());
                        profileRequestView.onEdit();
                        profileRequestView.enableSave(true);
                    }
                    else{
                        profileRequestView.showMessage(editProfileData.getMessage());
                        profileRequestView.showLoading(false);
                        profileRequestView.enableSave(true);
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                    profileRequestView.showMessage("Success Null");
                    profileRequestView.enableSave(true);
                }
            }

            @Override
            public void onFailure(String r) {
                profileRequestView.showLoading(false);
                profileRequestView.showMessage(r);
                profileRequestView.enableSave(true);
            }
        });
    }
}
