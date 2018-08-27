package com.legacy.aether.blocks.natural.tree;

import java.util.Random;

import com.legacy.aether.world.biome.feature.SkyrootTreeFeature;

import net.minecraft.block.trees.AbstractTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class SkyrootTree extends AbstractTree
{

	@Override
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random randIn)
	{
		return new SkyrootTreeFeature();
	}

}