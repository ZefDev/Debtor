package com.mandriklab.Debtor.Model;


import android.content.Context;
import android.os.AsyncTask;

import com.mandriklab.Debtor.Model.DAO.DebtorsDao;
import com.mandriklab.Debtor.Model.Entity.Debtors;

import java.util.Date;
import java.util.List;

public class DebtorsModel implements DebtorsDao {

    private DebtorsDao debtorsDao;


    public DebtorsModel(Context context) {
        debtorsDao = AppDatabase.getInstance(context).debtorsDao();
    }

    public void loadDebtors(LoadDebtorsCallback callback) {
        LoadDebtors loadDebtors = new LoadDebtors(callback);
        loadDebtors.execute();
    }

    public void addDebtors(Debtors debtors, List<Debtors> listDebtors, CompleteCallback callback) {
        AddDebtors addDebtors = new AddDebtors(callback);
        addDebtors.execute(debtors,listDebtors);
    }

    public void deleteSite(Debtors debtors,CompleteCallback completeCallback) {
        DeleteDebtors deleteDebtors = new DeleteDebtors(completeCallback);
        deleteDebtors.execute(debtors);
    }
    public void updateSite(Debtors debtors,CompleteCallback completeCallback) {
        UpdateDebtors updateDebtors = new UpdateDebtors(completeCallback);
        updateDebtors.execute(debtors);
    }

    @Override
    public List<Debtors> getAll() {
        return null;
    }

    @Override
    public Debtors getById(int id) {
        return null;
    }

    @Override
    public List<Debtors> loadAllByIds(int[] userIds) {
        return null;
    }

    @Override
    public void updateSite(Debtors... debtors) {

    }

    @Override
    public long[] insertAll(Debtors... debtors) {
        return new long[0];
    }

    @Override
    public void delete(Debtors debtors) {

    }


    public interface LoadDebtorsCallback {
        void onLoad(List<Debtors> debtors);
    }

    public interface AddSiteCallback {
        void onLoad(Debtors debtors);
    }

    public interface CompleteCallback {
        void onComplete();
    }

    class LoadDebtors extends AsyncTask<Void, Void, List<Debtors>> {

        private final LoadDebtorsCallback callback;

        LoadDebtors(LoadDebtorsCallback callback) {
            this.callback = callback;
        }
        @Override
        protected List<Debtors> doInBackground(Void... params) {
            List<Debtors> debtors = debtorsDao.getAll();
            return debtors;
        }

        @Override
        protected void onPostExecute(List<Debtors> debtors) {
            if (callback != null) {
                callback.onLoad(debtors);
            }
        }
    }


    class AddDebtors extends AsyncTask<Object, Void, Void> {

        private final CompleteCallback callback;

        AddDebtors(CompleteCallback callback) {
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

    class UpdateDebtors extends AsyncTask<Debtors, Void, Void> {

        private final CompleteCallback callback;

        UpdateDebtors(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Debtors... params) {

            debtorsDao.updateSite(params[0]);
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

    class DeleteDebtors extends AsyncTask<Debtors, Void, Void> {

        private final CompleteCallback callback;

        DeleteDebtors(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Debtors... params) {
            debtorsDao.delete(params[0]);
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

