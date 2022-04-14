package ru.itis.ruzavin.infsecondsemsemesterwork.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class CloudinaryHelper {
	@Getter
	private static Cloudinary cloudinary;

	public CloudinaryHelper() {
		if (cloudinary == null) {
			cloudinary = new Cloudinary(ObjectUtils.asMap(
					"cloud_name", "de5binygw",
					"api_key", "967433251694596",
					"api_secret", "DmISE6bttvpM-ZV3TaBWsTYaRIY"));
		}
	}

}