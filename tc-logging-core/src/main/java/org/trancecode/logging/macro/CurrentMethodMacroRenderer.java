/*
 * Copyright 2010 Herve Quiroz
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
package org.trancecode.logging.macro;

import org.trancecode.logging.Logger;
import org.trancecode.logging.spi.Loggers;

/**
 * @author Herve Quiroz
 */
public final class CurrentMethodMacroRenderer implements MacroRenderer
{
    @Override
    public Object get()
    {
        final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        for (int i = 1; i < stackTraceElements.length; i++)
        {
            if (!stackTraceElements[i].getClassName().equals(Loggers.class.getName())
                    && !stackTraceElements[i].getClassName().equals(Logger.class.getName())
                    && !stackTraceElements[i].getClassName().equals(CurrentMethodMacroRenderer.class.getName()))
            {
                return stackTraceElements[i].getMethodName() + "()";
            }
        }

        return "<unknown>";
    }

    @Override
    public String name()
    {
        return "@method";
    }
}
