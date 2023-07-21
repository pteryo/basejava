package com.learnjava.storage;
import com.learnjava.exception.ExistStorageException;
import com.learnjava.exception.NotExistStorageException;
import com.learnjava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract Object getSearchKey(String uuid);

    protected abstract void Update(Resume r, Object searchKey);

    protected abstract boolean Exist(Object searchKey);

    protected abstract void Save(Resume r, Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void Delete(Object searchKey);

    public void update(Resume r) {
        Object searchKey = getExistedSearchKey(r.getUuid());
        Update(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistedSearchKey(r.getUuid());
        Save(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        Delete(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return getResume(searchKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!Exist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (Exist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
