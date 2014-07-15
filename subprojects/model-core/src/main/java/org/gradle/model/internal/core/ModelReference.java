/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.model.internal.core;

public class ModelReference<T> {

    private final ModelPath path;
    private final ModelType<T> type;

    public ModelReference(ModelPath path, ModelType<T> type) {
        this.path = path;
        this.type = type;
    }

    public static <T> ModelReference<T> of(ModelPath path, ModelType<T> type) {
        return new ModelReference<T>(path, type);
    }

    public static <T> ModelReference<T> of(String path, Class<T> type) {
        return new ModelReference<T>(new ModelPath(path), ModelType.of(type));
    }

    public ModelReference(String modelPath, ModelType<T> type) {
        this(new ModelPath(modelPath), type);
    }

    public ModelPath getPath() {
        return path;
    }

    public ModelType<T> getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModelReference that = (ModelReference) o;

        return path.equals(that.path) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = path.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ModelReference{path=" + path + ", type=" + type + '}';
    }
}
