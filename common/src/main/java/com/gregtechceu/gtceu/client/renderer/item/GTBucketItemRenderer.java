package com.gregtechceu.gtceu.client.renderer.item;

import com.gregtechceu.gtceu.GTCEu;
import com.lowdragmc.lowdraglib.client.renderer.impl.IModelRenderer;

/**
 * @author KilaBash
 * @date 2023/3/28
 * @implNote GTBucketItemRenderer
 */
public class GTBucketItemRenderer extends IModelRenderer {

    public static final GTBucketItemRenderer INSTANCE = new GTBucketItemRenderer(false);
    public static final GTBucketItemRenderer INSTANCE_GAS = new GTBucketItemRenderer(true);

    protected GTBucketItemRenderer(boolean isGas) {
        super(GTCEu.id("item/bucket/" + (isGas ? "bucket_gas" : "bucket")));
    }
}
