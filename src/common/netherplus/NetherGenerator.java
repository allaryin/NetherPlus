package netherplus;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.src.BiomeGenHell;

public class NetherGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.worldType) {
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}
	
	public void generateNether(World world, Random rand, int chunkX, int chunkZ) {
        for(int i = 0; i < 3; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(96);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(NetherPlus.oreBlackDiamond.blockID, 4)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
        for(int i = 0; i < 2; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(96);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(NetherPlus.oreMolten.blockID, 4)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
        for(int i = 0; i < 7; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(96);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(NetherPlus.oreNetheridium.blockID, 7)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
        for(int i = 0; i < 10; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(96);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(NetherPlus.oreNetherCoal.blockID, 8)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
        /*
        for(int i = 0; i < 5; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(96);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new NPGenMinable(oreFieryCrystal.blockID, 3)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
        for(int i = 0; i < 5; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(96);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new NPGenMinable(oreDarkCrystal.blockID, 3)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
        */
	}
	
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {/*
        for(int i = 0; i < 7; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(32);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(oreWaterCrystal.blockID, 3)).generate(world, rand, randPosX, randPosY, randPosZ);
        }*/
	}
}
