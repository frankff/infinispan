package org.infinispan.query.affinity;

import java.util.List;

import org.apache.lucene.store.LockObtainFailedException;
import org.hibernate.search.backend.LuceneWork;

/**
 * Callback for indexing backend exception handling.
 *
 * @since 9.0
 */
interface OperationFailedHandler {

   /**
    * Called when a {@link LockObtainFailedException} happened in the backend.
    *
    * @param failingOperations Operations that failed to be applied to the index.
    */
   void lockObtainFailed(List<LuceneWork> failingOperations);
}
