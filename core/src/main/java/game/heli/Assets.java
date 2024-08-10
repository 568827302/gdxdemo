package game.heli;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {

    public static final String FONT_ZHFONT = "font/Zhfont.ttf";

    public static final String SKIN_UIKSIN = "ui/uiskin.json";

    /**
     * 加载全局基本资源
     */
    public static void loadGlobalRes() {
        AssetManager manager = getInstance().manager;
        manager.load(SKIN_UIKSIN, Skin.class);
    }

    AssetManager manager = new AssetManager();
    private Assets() {
        manager.setLoader();
    }
    static class AM {
        static final Assets instance = new Assets();
    }
    public static Assets getInstance() {
        return AM.instance;
    }
}
