package game.heli.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ai.btree.decorator.Random;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import de.eskalon.commons.screen.transition.impl.BlendingTransition;
import game.heli.NewGame;
import game.heli.util.ShapeDrawerUtil;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class SlideScreen1 extends MyScreenAdapter {
    
    Texture onePixmapTexture;
    ShapeDrawer drawer;
    
    boolean next = false;
    
    final int TEXT_BOUND_WIDTH = 900;
    final int TEXT_BOUND_HEIGHT = 500;
    final Color color;
    final String msg;
    
    public SlideScreen1(NewGame game, String msg, Color color) {
        super(game, new StretchViewport(0, 0));
        this.msg = msg;
        this.color = color;
    }
    
    @Override
    public void show() {
        super.show();
        
        onePixmapTexture = ShapeDrawerUtil.initOnePixmapTexture();
        drawer = ShapeDrawerUtil.init(this.mainBatch, this.onePixmapTexture);
        
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
                    game.getScreenManager()
                        .pushScreen(
                            new SlideScreen1(game, Integer.valueOf(msg).toString(),
                                new Color(Color.rgba8888(MathUtils.random(255),MathUtils.random(255),MathUtils.random(255),1))),
                            new BlendingTransition(mainBatch, 1F, Interpolation.pow2In)
                        );
                    return true;
            }
        });
    }
    
    @Override
    protected void mainBatchDraw(SpriteBatch batch, float delta) {
        super.mainBatchDraw(batch, delta);
        
        drawer.filledRectangle(
            (Gdx.graphics.getWidth() - TEXT_BOUND_WIDTH) / 2f ,
             (Gdx.graphics.getHeight() - TEXT_BOUND_HEIGHT) / 2f,
             TEXT_BOUND_WIDTH, TEXT_BOUND_HEIGHT, color);
    }
    
    @Override
    public void dispose() {
        super.dispose();
        onePixmapTexture.dispose();
    }
    
    
    
    
    
}
