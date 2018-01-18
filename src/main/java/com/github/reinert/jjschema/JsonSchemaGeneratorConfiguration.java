package com.github.reinert.jjschema;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class JsonSchemaGeneratorConfiguration {

    public static Builder builder() {
        return new AutoValue_JsonSchemaGeneratorConfiguration.Builder()
                .setNodeFactory(JsonNodeFactory.instance)
                .setSortSchemaProperties(true)
                .setAddSchemaVersion(true)
                .setProcessAnnotatedOnly(false)
                .setProcessPropertiesOnly(false)
                .setProcessFieldsOnly(false);
    }

    public abstract JsonNodeFactory nodeFactory();

    public abstract boolean addSchemaVersion();

    public abstract boolean sortSchemaProperties();

    public abstract boolean processAnnotatedOnly();

    public abstract boolean processPropertiesOnly();

    public abstract boolean processFieldsOnly();

    @AutoValue.Builder
    public abstract static class Builder {

        abstract Builder setNodeFactory(JsonNodeFactory nodeFactory);

        abstract Builder setAddSchemaVersion(boolean addSchemaVersion);

        abstract Builder setSortSchemaProperties(boolean sortSchemaProperties);

        abstract Builder setProcessAnnotatedOnly(boolean processAnnotatedOnly);

        abstract Builder setProcessPropertiesOnly(boolean processPropertiesOnly);

        abstract Builder setProcessFieldsOnly(boolean processFieldsOnly);

        public Builder removeSchemaVersion() {
            return setAddSchemaVersion(false);
        }

        public Builder dontSortSchemaProperties() {
            return setSortSchemaProperties(false);
        }

        public Builder processAnnotatedOnly() {
            return setProcessAnnotatedOnly(true);
        }

        public Builder processFieldsOnly() {
            return setProcessFieldsOnly(true);
        }

        public Builder processPropertiesOnly() {
            return setProcessPropertiesOnly(true);
        }

        public Builder customNodeFactory(JsonNodeFactory nodeFactory) {
            return setNodeFactory(nodeFactory);
        }

        public abstract JsonSchemaGeneratorConfiguration build();
    }
}