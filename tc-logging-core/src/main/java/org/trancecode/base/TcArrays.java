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
package org.trancecode.base;

/**
 * Utility methods related to arrays.
 * 
 * @author Herve Quiroz
 */
public final class TcArrays
{
    private static final Class<?> OBJECT_ARRAY_CLASS = new Object[0].getClass();

    private TcArrays()
    {
        // No instantiation
    }

    /**
     * Returns {@code true} if the specified object is an array.
     */
    public static boolean isArray(final Object object)
    {
        return OBJECT_ARRAY_CLASS.isAssignableFrom(object.getClass());
    }
}
