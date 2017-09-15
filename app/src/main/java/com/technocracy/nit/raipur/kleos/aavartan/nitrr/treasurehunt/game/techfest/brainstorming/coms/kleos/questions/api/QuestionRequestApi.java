package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 12/9/17.
 */

public interface QuestionRequestApi {

    @GET(Urls.REQUEST_QUESTION)
    Call<QuestionData> requestQuestion(@Query(Keys.KEY_ACCESS_TOKEN) String access_token);

    @FormUrlEncoded
    @POST(Urls.REQUEST_QUESTION)
    Call<QuestionResponseData> responseQuestion(@Field(Keys.KEY_ACCESS_TOKEN) String access_token,
                                                @Field(Keys.KEY_QUESTION_N0) String question_no,
                                                @Field(Keys.KEY_ANSWER) String answer
                                        );
}
