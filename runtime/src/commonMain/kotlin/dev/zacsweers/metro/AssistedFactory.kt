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
 * Annotates an abstract class or interface used to create an instance of a type via an assisted
 * [Inject] constructor.
 *
 * An [AssistedFactory]-annotated type must obey the following constraints:
 * - The type must be an abstract class or interface,
 * - The type must contain exactly one abstract, non-default method whose return type must exactly
 *   match the type of an assisted injection type, and parameters must match the exact list of
 *   [Assisted] parameters in the assisted injection type's constructor (and in the same order).
 *
 * ## Automatic Assisted Factory Generation
 *
 * Metro supports automatic generation of assisted factories via opt-in compiler option. If enabled,
 * Metro will automatically generate a default factory as a nested class within the injected type.
 *
 * ```
 * @Inject
 * class HttpClient(
 *   @Assisted timeoutDuration: Duration,
 *   cache: Cache,
 * ) {
 *   // Generated by Metro
 *   @AssistedFactory
 *   fun interface Factory {
 *     fun create(timeoutDuration: Duration): HttpClient
 *   }
 * }
 * ```
 *
 * If a nested class called `Factory` is already present, Metro will do nothing.
 *
 * ### Why opt-in?
 *
 * The main reason this is behind an opt-in option at the moment is because compiler plugin IDE
 * support is rudimentary at best and currently requires enabling a custom registry flag. TODO link
 * registry flag docs.
 *
 * Because of this, it's likely better for now to just hand-write the equivalent class that Metro
 * generates. If you still wish to proceed with using this, it can be enabled via the Gradle DSL.
 *
 * ```
 * metro {
 *   generateAssistedFactories.set(true)
 * }
 * ```
 *
 * @see Assisted
 * @see Inject
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
public annotation class AssistedFactory
