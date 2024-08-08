package game.heli.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.eskalon.commons.screen.ManagedScreen;

import game.heli.NewGame;

public class MyScreenAdapter extends ManagedScreen {
    protected NewGame game;
    protected SpriteBatch mainBatch;
    
    protected Viewport viewport;

    public MyScreenAdapter() {
        viewport = new ScreenViewport(new OrthographicCamera());
    }

    public MyScreenAdapter(NewGame game, Viewport viewport) {
        this.game = game;
        this.mainBatch = game.batch;
        this.viewport = viewport;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        beforeMainBatchDraw(delta);
        mainBatch.begin();
        mainBatchDraw(mainBatch, delta);
        mainBatch.end();
        afterMainBatchDraw(delta);
    }
    
    protected void beforeMainBatchDraw(float delta) {
    	// 一般在笔刷前做一些逻辑处理
    }
    
    protected void mainBatchDraw(SpriteBatch batch, float delta) {
    	// 实现这个方法在内部使用主笔刷
    }
    
    protected void afterMainBatchDraw(float delta) {
        // 一般在笔刷后做逻辑处理或者stage更新画图
    }

    @Override
    public void resize(int width, int heigth) {
        
    }

    @Override
    public void dispose() {
        
    }
}
