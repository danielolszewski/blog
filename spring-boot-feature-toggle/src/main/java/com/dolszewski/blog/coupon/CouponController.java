package com.dolszewski.blog.coupon;

import com.dolszewski.blog.FeatureDecisions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/coupons")
class CouponController {

    private final FeatureDecisions featureDecisions;

    CouponController(FeatureDecisions featureDecisions) {
        this.featureDecisions = featureDecisions;
    }

    @GetMapping
    List<String> listCouponNames() {
        if (!featureDecisions.couponEnabled()) {
            throw new NotSupportedException();
        }
        return Arrays.asList("First deal coupon", "10% coupon");
    }

}
