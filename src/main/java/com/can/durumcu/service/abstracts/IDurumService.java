package com.can.durumcu.service.abstracts;

import com.can.durumcu.core.results.DataResult;
import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.Durum;

public interface IDurumService {
    Result add(Durum durum);

    DataResult<Durum> getByName(String name);
}
