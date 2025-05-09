/*
 * Copyright (C) 2020 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.zacsweers.metro

/**
 * Annotates an _assisted_ parameter in an injected class or function. An assisted parameter is one
 * that is supplied at instantiation-time rather than from the dependency graph.
 *
 * @see Inject Inject's kdoc for full documentation on assisted injection with examples.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
public annotation class Assisted(
  /**
   * Returns an identifier for an [Assisted] parameter.
   *
   * Within an [Inject] constructor, each [Assisted] parameter must be uniquely defined by the
   * combination of its identifier and type. If no identifier is specified, the default identifier
   * is an empty string. Thus, the following parameters are equivalent within an [Inject]
   * constructor:
   * * `@Assisted foo: Foo`
   * * `@Assisted("") foo: Foo`
   *
   * Within an [AssistedFactory] method, each parameter must match an [Assisted] parameter in the
   * associated [Inject] constructor (i.e. identifier + type). A parameter with no `@Assisted`
   * annotation will be assigned the default identifier. Thus, the following parameters are
   * equivalent within an [AssistedFactory] method:
   * * `foo: Foo`
   * * `@Assisted foo: Foo`
   * * `@Assisted("") foo: Foo`
   *
   * Example:
   * ```
   * class DataService(
   *   bindingFromDagger: BindingFromDagger,
   *   @Assisted name: String,
   *   @Assisted("id") id: String,
   *   @Assisted("repo") repo: String,
   * )
   *
   * @AssistedFactory
   * fun interface DataServiceFactory {
   *   fun create(
   *     name: String,
   *     @Assisted("id") id: String,
   *     @Assisted("repo") repo: String,
   *   ): DataService
   * }
   * ```
   */
  val value: String = ""
)
