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

package sorcer.core.invoker;

import java.rmi.RemoteException;

import sorcer.core.context.model.ent.Proc;
import sorcer.core.context.model.ent.ProcModel;
import sorcer.service.Arg;
import sorcer.service.ArgSet;
import sorcer.service.Context;
import sorcer.service.ContextException;
import sorcer.service.InvocationException;

/**
 * @author Mike Sobolewski
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RunnableInvoker<T> extends ServiceInvoker<T> {
	
	private static final long serialVersionUID = 4946544252868946576L;
	
	{
		defaultName = "runnable-";
	}
	
	private Runnable runnable;
	 
	public RunnableInvoker(ProcModel context) {
		super(context);
	}
	
	public RunnableInvoker(ProcModel context, Runnable runnable, Proc... procEntries) {
		super(context);
		this.runnable = runnable;
		this.args = new ArgSet(procEntries);
	}

	public RunnableInvoker(String name, Runnable runnable, Proc... procEntries) {
		super(name);
		this.runnable = runnable;
		this.args = new ArgSet(procEntries);
	}
	
	@Override
	public T invoke(Context context, Arg... entries)
			throws RemoteException, InvocationException {
		try {
			invokeContext.append(context);
		} catch (ContextException e) {
			throw new InvocationException(e);
		}
		new Thread(runnable).start();
		return null;
	}
	
	@Override
	public T invoke(Arg... entries) throws RemoteException,
			InvocationException {
		return invoke((Context) null, entries);
	}
}
