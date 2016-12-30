package pw.megaviral.recipeproject;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by awais-pc on 12/12/2016.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Roboto/Roboto-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }
}
