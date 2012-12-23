package org.toadally.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;
import java.io.Serializable;

@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable {
	private static final long serialVersionUID = 4285461695842942171L;

	@Inject
	private UserTransaction utx;

	@AroundInvoke
	public Object applyTransaction(InvocationContext ic) throws Exception {
		Transactional tx = ic.getMethod().getAnnotation(Transactional.class);

		if (tx.value() == TransactionalType.REQUIRED) {

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
		} else if (tx.value() == TransactionalType.REQUIRES_NEW) {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		return ic.proceed();

	}
}