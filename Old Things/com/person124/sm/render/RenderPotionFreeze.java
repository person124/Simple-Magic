package com.person124.sm.render;

import java.util.EnumSet;

import org.lwjgl.opengl.GL11;

import com.person124.sm.common.mod_SimpleMagic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderPotionFreeze implements ITickHandler{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().currentScreen != null) return;
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if(player.isPotionActive(mod_SimpleMagic.freezePotion.id)) {
			GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
			
			Tessellator t = Tessellator.instance;
			
			ScaledResolution scale = new ScaledResolution(Minecraft.getMinecraft().gameSettings, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
			int width = scale.getScaledWidth();
			int height = scale.getScaledHeight();
			
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			ResourceLocation res = new ResourceLocation("simplemagic", "textures/gui/freeze.png");
			System.out.println(res.toString());
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, Minecraft.getMinecraft().renderEngine.getTexture(res).getGlTextureId());

			t.startDrawingQuads();
			t.addVertexWithUV(0.0D, (double) height, 90.0D, 0.0D, 1.0D);
			t.addVertexWithUV((double) width, (double) height, 90.0D, 1.0D, 1.0D);
			t.addVertexWithUV((double) width, 0.0D, 90.0D, 1.0D, 0.0D);
			t.addVertexWithUV(0.0D, 0.0D, 90.0D, 0.0D, 0.0D);
			t.draw();

			GL11.glPopAttrib();
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "freeze potion tick hendler";
	}
	
	

}
