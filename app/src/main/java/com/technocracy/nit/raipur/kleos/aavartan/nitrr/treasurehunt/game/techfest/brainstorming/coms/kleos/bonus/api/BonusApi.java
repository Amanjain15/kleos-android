package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionResponseData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 14/9/17.
 */

public interface BonusApi {
    @GET(Urls.REQUEST_BONUS)
    Call<QuestionData> requestQuestion(@Query(Keys.KEY_ACCESS_TOKEN) String access_token);

    @FormUrlEncoded
    @POST(Urls.REQUEST_BONUS)
    Call<QuestionResponseData> responseQuestion(@Field(Keys.KEY_ACCESS_TOKEN) String access_token,
                                                @Field(Keys.KEY_QUESTION_N0) String question_no,
                                                @Field(Keys.KEY_ANSWER) String answer
    );
}
