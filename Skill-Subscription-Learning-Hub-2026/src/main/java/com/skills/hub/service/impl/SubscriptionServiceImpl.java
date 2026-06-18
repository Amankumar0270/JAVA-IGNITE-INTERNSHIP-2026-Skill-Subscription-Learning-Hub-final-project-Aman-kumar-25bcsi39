package com.skills.hub.service.impl;

import com.skills.hub.model.Subscription;
import com.skills.hub.model.User;
import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SubscriptionRepository;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.repository.SkillPackRepository;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepo;
    private final UserRepository userRepo;
    private final SkillPackRepository packRepo;

    public SubscriptionServiceImpl(SubscriptionRepository subRepo, UserRepository userRepo, SkillPackRepository packRepo) {
        this.subRepo = subRepo;
        this.userRepo = userRepo;
        this.packRepo = packRepo;
    }

    @Override
    public Subscription subscribe(Long userId, Long packId) {
        if (userId == null || packId == null) {
            return null;
        }
        User user = userRepo.findById(userId).orElse(null);
        SkillPack pack = packRepo.findById(packId).orElse(null);
        if (user == null || pack == null) {
            return null;
        }

        Subscription sub = new Subscription();
        sub.setUser(user);
        sub.setSkillPack(pack);
        sub.setStartDate(LocalDate.now());
        sub.setEndDate(LocalDate.now().plusDays(30));
        sub.setStatus("ACTIVE");

        return subRepo.save(sub);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        if (userId == null) {
            return Collections.emptyList();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }
        return subRepo.findByUser(user);
    }

	public SubscriptionRepository getSubRepo() {
		return subRepo;
	}
}