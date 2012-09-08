package netherplus;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.Container;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiScreen;

public class GuiSpellbook extends GuiContainer {
	
	public GuiSpellbook(Container container) {
		super(container);
	}
	
	public void initGui() {
		super.initGui();
	}
	
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
    	int bgTexture = mc.renderEngine.getTexture("/netherplus/SpellBook.png");
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	mc.renderEngine.bindTexture(bgTexture);
    	int posx = (width - xSize) / 2;
    	int posy = (height - ySize) / 2;
    	drawTexturedModalRect(posx, posy, 0, 0, xSize, ySize);
    }
}
