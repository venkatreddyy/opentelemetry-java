/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.sdk.autoconfigure;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigurablePropagatorProvider;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

public class TestConfigurablePropagatorProvider implements ConfigurablePropagatorProvider {
  @Override
  public TextMapPropagator getPropagator() {
    return new TextMapPropagator() {
      @Override
      public Collection<String> fields() {
        return Collections.singleton("test");
      }

      @Override
      public <C> void inject(Context context, @Nullable C carrier, Setter<C> setter) {}

      @Override
      public <C> Context extract(Context context, @Nullable C carrier, Getter<C> getter) {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public String getName() {
    return "test";
  }
}