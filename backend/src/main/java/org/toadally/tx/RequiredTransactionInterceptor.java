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
@Transactional(TransactionalType.REQUIRED)
@Interceptor
public class RequiredTransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 7787034546031884945L;
	@Inject
	private UserTransaction utx;

	@AroundInvoke
	public Object applyTransaction(InvocationContext ic) throws Exception {
		boolean startedTransaction = false;
		if (utx.getStatus() != Status.STATUS_ACTIVE) {
			utx.begin();
			startedTransaction = true;
		}

		Object ret;
		try {
			ret = ic.proceed();

			if (startedTransaction) {
				utx.commit();
			}
		} catch (Exception t) {
			if (startedTransaction) {
				utx.rollback();
			}

			throw t;
		}

		return ret;
	}
}