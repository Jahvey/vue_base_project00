package com.cdgit.loan.csm.common;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 将BigDecimal返回前端成String类型
 * @author GIT-cd
 *
 */
public class BigDecimalConvertToString extends JsonSerializer<BigDecimal>{

	@Override
	public void serialize(BigDecimal arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		arg1.writeString(arg0.toString());
	}
}
