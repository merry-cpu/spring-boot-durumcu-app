package com.can.durumcu.service.abstracts;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.core.results.SuccessDataResult;
import com.can.durumcu.entity.Durum;

import java.util.List;

public interface IDurumService {

    Result add(Durum durum);

    SuccessDataResult<List<Durum>> getByName(String name);
}
