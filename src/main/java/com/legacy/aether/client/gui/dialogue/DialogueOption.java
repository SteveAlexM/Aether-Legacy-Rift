package com.legacy.aether.client.gui.dialogue;

import net.minecraft.block.GrassBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.audio.*;
import net.minecraft.client.gui.Gui;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TextFormat;

public class DialogueOption extends Gui
{

	private int dialogueId;

	private String dialogueText;

	private int xPosition, yPosition;

	private int height, width;

	private MinecraftClient mc = MinecraftClient.getInstance();

	public DialogueOption(String dialogueText)
	{
		this.dialogueText = "[" + dialogueText + "]";
		this.height = 12;
		this.width = this.mc.fontRenderer.getStringWidth(this.dialogueText) + 2;
	}

	public void renderDialogue(double mouseX, double mouseY)
	{
        this.drawGradientRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 0x66000000, 0x66000000);
        this.drawString(this.mc.fontRenderer, this.isMouseOver(mouseX, mouseY) ? TextFormat.YELLOW.toString() + this.getDialogueText() : this.getDialogueText(), this.xPosition + 2, this.yPosition + 2, 0xffffff);
	}

	public boolean isMouseOver(double mouseX, double mouseY)
	{
		return mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
	}

    public void playPressSound(SoundLoader soundHandlerIn)
    {
    	// TODO - 1.14
        //soundHandlerIn.play(.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
    }

	public void setDialogueText(String dialogueText)
	{
		this.dialogueText = "[" + dialogueText + "]";
		this.width = this.mc.fontRenderer.getStringWidth(this.dialogueText) + 2;
	}

	public void setXPosition(int xPosition)
	{
		this.xPosition = xPosition;
	}

	public void setYPosition(int yPosition)
	{
		this.yPosition = yPosition;
	}

	public void setDialogueId(int id)
	{
		this.dialogueId = id;
	}

	public int getDialogueId()
	{
		return this.dialogueId;
	}

	public int getHeight()
	{
		return this.height;
	}

	public int getWidth()
	{
		return this.width;
	}

	public String getDialogueText()
	{
		return this.dialogueText;
	}

}