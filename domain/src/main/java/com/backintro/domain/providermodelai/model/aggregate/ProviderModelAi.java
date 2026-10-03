package com.backintro.domain.providermodelai.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.providermodelai.event.ProviderModelAiRegisteredEvent;
import com.backintro.domain.providermodelai.event.ProviderModelAiUpdatedEvent;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public class ProviderModelAi extends AggregateRoot {
    private final ProviderModelAiId id;
    private String name;
    private String code;
    private boolean active;

    private ProviderModelAi(
            ProviderModelAiId id,
            String name,
            String code,
            boolean active) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }

    public static ProviderModelAi register(
            String name,
            String code) {
        ProviderModelAiId id = ProviderModelAiId.generate();
        ProviderModelAi aggregate = new ProviderModelAi(id, name, code, true);
        aggregate.recordEvent(new ProviderModelAiRegisteredEvent(id, LocalDateTime.now()));
        return aggregate;
    }

    public static ProviderModelAi restore(
            ProviderModelAiId id,
            String name,
            String code,
            boolean active) {
        return new ProviderModelAi(id, name, code, active);
    }

    public void update(
            String name,
            String code) {
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        recordEvent(new ProviderModelAiUpdatedEvent(this.id, this.name, this.code, LocalDateTime.now()));
    }

    public ProviderModelAiId id() { return id; }
    public String name() { return name; }
    public String code() { return code; }
    public boolean active() { return active; }
}
