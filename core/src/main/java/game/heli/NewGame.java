package game.heli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

import de.eskalon.commons.core.ManagedGame;
import de.eskalon.commons.screen.ManagedScreen;
import de.eskalon.commons.screen.transition.ScreenTransition;
import de.eskalon.commons.screen.transition.impl.BlendingTransition;

import game.heli.screen.SlideScreen1;

public class NewGame extends ManagedGame<ManagedScreen, ScreenTransition> {

    public SpriteBatch batch;
    
    @Override
    public void create() {
        super.create();
        batch = new SpriteBatch();
       
		// Enable automatic disposing
		this.screenManager.setAutoDispose(true, true);

		// Push the first screen using a blending transition
		this.screenManager.pushScreen(new SlideScreen1(this, "0", Color.YELLOW),
				new BlendingTransition(batch, 1F, Interpolation.pow2In));

		Gdx.app.debug("Game", "Initialization finished.");
    }
}
