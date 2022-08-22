package com.can.durumcu.service.concretes;

import com.can.durumcu.core.results.DataResult;
import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.Durum;
import com.can.durumcu.service.abstracts.IDurumService;
import org.springframework.stereotype.Service;

@Service
public class DurumService implements IDurumService {
    @Override
    public Result add(Durum durum) {
        return null;
    }

    @Override
    public DataResult<Durum> getByName(String name) {
        return null;
    }
}
