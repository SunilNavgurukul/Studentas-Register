
package com.sunil__parcha.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sunil__parcha.modal.User;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String COLLECTION_NAME = "user";

	@Override
	public List<User> getUserList() {
		if (!mongoTemplate.collectionExists(User.class)) {
			System.out.println("Hello");
		}
		return mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}

	@Override
	public void add(User user) {
		if (!mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.createCollection(User.class);
		}
		user.setId(UUID.randomUUID().toString());
		mongoTemplate.save(user);
	}

	@Override
	public void update(User user) {
		mongoTemplate.save(user);
	}

	@Override
	public User findByUserId(String id) {
		return mongoTemplate.findById(id, User.class);

	}

	@Override
	public List<User> findLikeUserName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(name));
		List<User> data = mongoTemplate.find(query, User.class);
		return data;

	}

	@Override
	public List<User> AseAndDec(String name) {
		System.out.println(name);
		Query query = new Query();
		if (name.equals("asc_id")) {
			query.with(Sort.by(Sort.Direction.ASC, "id"));
		} else if (name.equals("dac_id")) {
			query.with(Sort.by(Sort.Direction.DESC, "id"));
		} else if (name.equals("asc_name")) {
			query.with(Sort.by(Sort.Direction.ASC, "name"));
		} else {
			query.with(Sort.by(Sort.Direction.DESC, "name"));
		}
		List<User> data = mongoTemplate.find(query, User.class);
		System.out.println(data);
		return data;

	}

	@Override
	public void delete(User user) {
		mongoTemplate.remove(user, COLLECTION_NAME);

	}

}