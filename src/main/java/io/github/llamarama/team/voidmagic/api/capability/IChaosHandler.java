package io.github.llamarama.team.voidmagic.api.capability;

import io.github.llamarama.team.voidmagic.common.util.config.ServerConfig;

public interface IChaosHandler {

    int getChaos();

    void setChaos(int newVal);

    default void consume(int amount) {
        int newVal = this.getChaos() - amount;

        if (newVal < ServerConfig.MIN_CHAOS.get())
            return;

        this.setChaos(newVal);
    }

    default void increase(int amount) {
        int newVal = this.getChaos() + amount;

        if (newVal > ServerConfig.MAX_CHAOS.get())
            return;

        this.setChaos(newVal);
    }

}
