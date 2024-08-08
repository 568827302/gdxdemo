package game.heli.util;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class ShapeDrawerUtil {
    public static Texture initOnePixmapTexture() {
        Pixmap p = new Pixmap(1, 1, Format.RGBA8888);
		p.setColor(Color.WHITE);
		p.drawPixel(0, 0);
		Texture t = new Texture(p);
        p.dispose();
        return t;
    }
    
    public static ShapeDrawer init(Batch batch, Texture onePixmapTexture) {
        TextureRegion tr = new TextureRegion(onePixmapTexture, 0, 0, 1, 1);
    	return new ShapeDrawer(batch, tr);
    }
}
