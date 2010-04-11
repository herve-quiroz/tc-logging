/*
 * Copyright 2010 TranceCode
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.trancecode.logging;

import com.google.common.base.Preconditions;

import java.util.concurrent.TimeUnit;

/**
 * @author Herve Quiroz
 */
public final class Duration
{
    public static Object of(final TimeUnit unit)
    {
        Preconditions.checkNotNull(unit);

        return new Object()
        {
            private final long startTime = System.nanoTime();

            @Override
            public String toString()
            {
                final long duration = System.nanoTime() - startTime;
                final long unitDuration = unit.convert(duration, TimeUnit.NANOSECONDS);
                return unitDuration + " " + unit.toString().toLowerCase();
            }
        };
    }
}