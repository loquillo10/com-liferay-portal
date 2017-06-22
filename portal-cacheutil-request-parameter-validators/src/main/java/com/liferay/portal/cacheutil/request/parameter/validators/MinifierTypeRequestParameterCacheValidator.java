/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.cacheutil.request.parameter.validators;

import com.liferay.portal.kernel.util.Function;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Carlos Sierra Andrés
 */
@Component(immediate = true, property = "cache.file.name.contributor=true")
public class MinifierTypeRequestParameterCacheValidator
	implements Function<HttpServletRequest, KeyValuePair> {

	@Override
	public KeyValuePair apply(HttpServletRequest request) {
		String minifierType = request.getParameter(_PARAMETER_NAME);

		if (Validator.isNull(minifierType)) {
			return null;
		}

		if (minifierType.equals("css") || minifierType.equals("js")) {
			return new KeyValuePair(_PARAMETER_NAME, minifierType);
		}

		return null;
	}

	private static final String _PARAMETER_NAME = "minifierType";

}