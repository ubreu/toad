/*
 * Copyright 2011, 2012 open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.toadally.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;
import java.io.Serializable;

/**
 * Extracted from an open knowledge GmbH workshop.
 */
@Transactional(TransactionalType.NONE)
@Interceptor
public class NoneTransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 6317655746038468572L;
	@Inject
	private UserTransaction utx;

	@AroundInvoke
	public Object applyTransaction(InvocationContext ic) throws Exception {
		if (utx.getStatus() != Status.STATUS_ACTIVE) {
			throw new IllegalStateException("Active transaction found. Aborting.");
		}

		return ic.proceed();
	}
}
