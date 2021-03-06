/*
 * Copyright 2013 the original author or authors.
 * Copyright 2013 SorcerSoft.org.
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

package sorcer.service;

/**
 * 
 * @author Mike Sobolewski
 * 
 */
public interface Incrementor<T> {

	/**
	 * Returns the next element of this incrementor.
	 * 
	 * @return the next eval of this incrementor.
	 * @exception NoSuchElementException
	 *                iteration has no more elements.
	 */
	T next();
	
	/**
	 * Resets the start eval of the incrementor.
	 * 
	 * @return the reseted incrementor.
	 */
	public Incrementor<T> reset();

}
