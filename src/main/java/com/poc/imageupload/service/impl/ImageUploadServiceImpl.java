/**
 * 
 */
package com.poc.imageupload.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poc.imageupload.dao.UserDao;
import com.poc.imageupload.dao.UserUploadDao;
import com.poc.imageupload.model.User;
import com.poc.imageupload.model.UserUpload;
import com.poc.imageupload.service.ImageUploadService;
import com.poc.imageupload.util.DateUtil;

/**
 * @author Eraine
 *
 */
@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserUploadDao userUploadDao;

	@Value("${upload.file.path}")
	private String uploadFilePath;

	@Override
	public void saveImages(User user, MultipartFile[] multipartFile) throws IllegalStateException, IOException {
		String uploadingDir = String.join(File.separator,
				new String[] { getRootDirectory(), uploadFilePath, user.getUsername(), "" });

		Path path = Paths.get(uploadingDir);

		if (!Files.exists(path)) {
			Files.createDirectories(path);
		}

		Set<UserUpload> uploads = new HashSet<>();

		for (MultipartFile m : multipartFile) {
			File file = new File(uploadingDir + m.getOriginalFilename());
			File newFile = new File(uploadingDir + DateUtil.getStringTime() + getFileExtension(file));

			System.out.println(newFile.getName());

			m.transferTo(file);

			Files.move(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			uploads.add(new UserUpload(getLocalDirectory(user, newFile), user));
		}

		user.setUserUpload(uploads);
		userDao.save(user);
	}

	protected String getLocalDirectory(User user, File file) {
		return String.join(File.separator, new String[] { uploadFilePath, user.getUsername(), file.getName() });
	}

	protected String getRootDirectory() {
		return System.getProperty("user.dir");
	}

	private String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}

	@Override
	public List<UserUpload> findAll() {
		return userUploadDao.findAll();
	}

	public User findById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public List<UserUpload> findByUser(User user) {
		return userUploadDao.findByUserOrderByUploadDateDesc(user);
	}

}
