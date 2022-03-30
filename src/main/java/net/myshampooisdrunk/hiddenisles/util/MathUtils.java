package net.myshampooisdrunk.hiddenisles.util;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MathUtils {
    public static double getLength(Vector3d pos){
        return(Math.sqrt(pos.x*pos.x+pos.y*pos.y+pos.z*pos.z));
    }
    public static double getYaw(Vector3d vec){
        return Math.atan2(vec.z, vec.x);
    }
    public static double getPitch(Vector3d pos){
        double l = getLength(pos);
        return Math.asin(pos.y/l);
    }
    public static double map(double value, double x0, double x1, double y0, double y1){
        return x1 + (y1 - x1) * ((value-x0)/(y0-x0));
    }

    public static Vector3d rotatePitch(Vector3d vec, float pitch) {
        float f = MathHelper.cos(pitch);
        float f1 = MathHelper.sin(pitch);
        double d0 = vec.x;
        double d1 = vec.y * (double) f + vec.z * (double) f1;
        double d2 = vec.z * (double) f - vec.y * (double) f1;
        return new Vector3d(d0, d1, d2);
    }

    public static Vector3d rotateYaw(Vector3d vec, float yaw) {
        float f = MathHelper.cos(yaw);
        float f1 = MathHelper.sin(yaw);
        double d0 = vec.x * (double) f + vec.z * (double) f1;
        double d1 = vec.y;
        double d2 = vec.z * (double) f - vec.x * (double) f1;
        return new Vector3d(d0, d1, d2);
    }

    public static Vector3d rotateRoll(Vector3d vec, float roll) {
        float f = MathHelper.cos(roll);
        float f1 = MathHelper.sin(roll);
        double d0 = vec.x * (double) f + vec.y * (double) f1;
        double d1 = vec.y * (double) f - vec.x * (double) f1;
        double d2 = vec.z;
        return new Vector3d(d0, d1, d2);
    }

    public static Vector3d normalize(Vector3d vec){
        double d = Math.sqrt(vec.x * vec.x + vec.y * vec.y + vec.z * vec.z);
        return new Vector3d(vec.x / d, vec.y / d, vec.z / d);
    }
    public static Vector3d normalize(Vec3d vec){
        double d = Math.sqrt(vec.x * vec.x + vec.y * vec.y + vec.z * vec.z);
        return d < 1.0E-4D ? new Vector3d(0.0D, 0.0D, 0.0D) : new Vector3d(vec.x / d, vec.y / d, vec.z / d);
    }

}
//all equations used here are from iskall's vault public mod on github, specific reference: https://github.com/Iskallia/Vault-public-S1/blob/master/src/main/java/iskallia/vault/util/MathUtilities.java