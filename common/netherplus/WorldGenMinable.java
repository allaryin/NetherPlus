package netherplus;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenMinable extends WorldGenerator
{
    private int minableBlockId;
    private int numberOfBlocks;

    public WorldGenMinable(int id, int num)
    {
        minableBlockId = id;
        numberOfBlocks = num;
    }

    public boolean generate(World world, Random rand, int i, int j, int k)
    {
        float var6 = rand.nextFloat() * (float)Math.PI;
        double var7 = (double)((float)(i + 8) + MathHelper.sin(var6) * (float)numberOfBlocks / 8.0F);
        double var9 = (double)((float)(i + 8) - MathHelper.sin(var6) * (float)numberOfBlocks / 8.0F);
        double var11 = (double)((float)(k + 8) + MathHelper.cos(var6) * (float)numberOfBlocks / 8.0F);
        double var13 = (double)((float)(k + 8) - MathHelper.cos(var6) * (float)numberOfBlocks / 8.0F);
        double var15 = (double)(j + rand.nextInt(3) - 2);
        double var17 = (double)(j + rand.nextInt(3) - 2);

        for (int var19 = 0; var19 <= numberOfBlocks; ++var19)
        {
            double var20 = var7 + (var9 - var7) * (double)var19 / (double)numberOfBlocks;
            double var22 = var15 + (var17 - var15) * (double)var19 / (double)numberOfBlocks;
            double var24 = var11 + (var13 - var11) * (double)var19 / (double)numberOfBlocks;
            double var26 = rand.nextDouble() * (double)numberOfBlocks / 16.0D;
            double var28 = (double)(MathHelper.sin((float)var19 * (float)Math.PI / (float)numberOfBlocks) + 1.0F) * var26 + 1.0D;
            double var30 = (double)(MathHelper.sin((float)var19 * (float)Math.PI / (float)numberOfBlocks) + 1.0F) * var26 + 1.0D;
            int var32 = MathHelper.floor_double(var20 - var28 / 2.0D);
            int var33 = MathHelper.floor_double(var22 - var30 / 2.0D);
            int var34 = MathHelper.floor_double(var24 - var28 / 2.0D);
            int var35 = MathHelper.floor_double(var20 + var28 / 2.0D);
            int var36 = MathHelper.floor_double(var22 + var30 / 2.0D);
            int var37 = MathHelper.floor_double(var24 + var28 / 2.0D);

            for (int var38 = var32; var38 <= var35; ++var38)
            {
                double var39 = ((double)var38 + 0.5D - var20) / (var28 / 2.0D);

                if (var39 * var39 < 1.0D)
                {
                    for (int var41 = var33; var41 <= var36; ++var41)
                    {
                        double var42 = ((double)var41 + 0.5D - var22) / (var30 / 2.0D);

                        if (var39 * var39 + var42 * var42 < 1.0D)
                        {
                            for (int var44 = var34; var44 <= var37; ++var44)
                            {
                                double var45 = ((double)var44 + 0.5D - var24) / (var28 / 2.0D);
                                if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D && world.getBlockId(var38, var41, var44) == Block.netherrack.blockID)
                                {
                                	world.setBlock(var38, var41, var44, minableBlockId);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
