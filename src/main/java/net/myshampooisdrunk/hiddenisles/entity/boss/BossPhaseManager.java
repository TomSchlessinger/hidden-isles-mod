package net.myshampooisdrunk.hiddenisles.entity.boss;

import com.mojang.logging.LogUtils;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.Phase;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class BossPhaseManager {
    private static final Logger LOGGER = LogUtils.getLogger();
    private final BossEntity boss;
    private int currentPhase;

    public BossPhaseManager(BossEntity boss) {
        this.boss = boss;
        this.setPhase(0);
    }

    public void setPhase(int i) {
        this.currentPhase = i;
    }

    public int getCurrent() {
        return this.currentPhase;
    }

}
