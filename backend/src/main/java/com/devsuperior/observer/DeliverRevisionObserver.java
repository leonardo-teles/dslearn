package com.devsuperior.observer;

import com.devsuperior.entities.Deliver;

public interface DeliverRevisionObserver {

	void onSaveRevision(Deliver deliver);
}
