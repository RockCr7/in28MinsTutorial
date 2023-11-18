package com.lcwd.user.service.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/filter")
public class FilterController {

	@GetMapping("/getOne")
	public MappingJacksonValue getOneBean() {
		ABC abc = new ABC("val1", "val2", "val3");
		MappingJacksonValue mapJack = new MappingJacksonValue(abc);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1", "feild3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ABCFilter", filter);

		mapJack.setFilters(filters);
		return mapJack;
	}

	@GetMapping("/getAll")
	public MappingJacksonValue getListOfBean() {
		List<ABC> list1 = Arrays.asList(new ABC("val1", "val2", "val3"), new ABC("key1", "key2","key3"));
		MappingJacksonValue mapJack = new MappingJacksonValue(list1);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("feild1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ABCFilter", filter);
		mapJack.setFilters(filters);
		return mapJack;
	}

}
