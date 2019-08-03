package com.mandriklab.Debtor.Model;

import android.content.Context;
import android.os.AsyncTask;

import com.mandriklab.Debtor.Model.DAO.OperationDao;
import com.mandriklab.Debtor.Model.Entity.Operation;

import java.util.Date;
import java.util.List;

public class OperationModel implements OperationDao {

    private OperationDao operationDao;


    public OperationModel(Context context) {
        operationDao = AppDatabase.getInstance(context).operationDao();
    }

    public void loadOperation(LoadOperationCallback callback) {
        LoadOperation loadOperation = new LoadOperation(callback);
        loadOperation.execute();
    }

    public void addOperation(Operation operation, List<Operation> listOperation, CompleteCallback callback) {
        AddOperation addOperation = new AddOperation(callback);
        addOperation.execute(operation,listOperation);
    }

    public void deleteOperation(Operation operation, CompleteCallback completeCallback) {
        DeleteOperation deleteOperation = new DeleteOperation(completeCallback);
        deleteOperation.execute(operation);
    }
    public void updateOperation(Operation operation, CompleteCallback completeCallback) {
        UpdateOperation updateOperation = new UpdateOperation(completeCallback);
        updateOperation.execute(operation);
    }

    @Override
    public List<Operation> getAll() {
        return null;
    }

    @Override
    public Operation getById(int id) {
        return null;
    }

    @Override
    public List<Operation> loadAllByIds(int[] OperationIds) {
        return null;
    }

    @Override
    public void updateSite(Operation... operation) {

    }

    @Override
    public long[] insertAll(Operation... operation) {
        return new long[0];
    }

    @Override
    public void delete(Operation operation) {

    }


    public interface LoadOperationCallback {
        void onLoad(List<Operation> operations);
    }

    public interface AddOperationCallback {
        void onLoad(Operation operation);
    }

    public interface CompleteCallback {
        void onComplete();
    }

    class LoadOperation extends AsyncTask<Void, Void, List<Operation>> {

        private final LoadOperationCallback callback;

        LoadOperation(LoadOperationCallback callback) {
            this.callback = callback;
        }
        @Override
        protected List<Operation> doInBackground(Void... params) {
            List<Operation> operation = operationDao.getAll();
            return operation;
        }

        @Override
        protected void onPostExecute(List<Operation> operation) {
            if (callback != null) {
                callback.onLoad(operation);
            }
        }
    }


    class AddOperation extends AsyncTask<Object, Void, Void> {

        private final CompleteCallback callback;

        AddOperation(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Object... params) {

            // Хуярим в базу новую замметку
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (callback != null) {
                callback.onComplete();
            }
        }

    }

    class UpdateOperation extends AsyncTask<Operation, Void, Void> {

        private final CompleteCallback callback;

        UpdateOperation(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Operation... params) {

            operationDao.updateSite(params[0]);
            // Хуярим в базу новую замметку
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (callback != null) {
                callback.onComplete();
            }
        }
    }

    class DeleteOperation extends AsyncTask<Operation, Void, Void> {

        private final CompleteCallback callback;

        DeleteOperation(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Operation... params) {
            operationDao.delete(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (callback != null) {
                callback.onComplete();
            }
        }
    }
}
