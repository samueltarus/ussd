package com.ussd.ussd.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "settings")
public class Setting  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "xe_endpoint")
    private String xeEndPoint;
    @Column(name = "xe_endpoint_username")


    private String xeEndPointUsername;
    @Column(name = "xe_endpoint_password")

    private String xeEndPointPassword;
    @Column(name = "xe_post_contribution_from_mss_stkpush_to_account")

    private String xePostContributionFromMssSTKPushToAccount;
    @Column(name = "enroll_grace_period")

    private String enrollGracePeriod;
    @Column(name = "max_login_retries")

    private String maxLoginRetries;
    @Column(name = "minimum_contribution")

    private String minimumContribution;
    @Column(name = "mpesa_paybill")

    private String mpesaPaybill;
    @Column(name = "mpesa_middleware_username")

    private String mpesaMiddlewareUsername;
    @Column(name = "mpesa_middleware_password")


    private String mpesaMiddlewarePassword;
    @Column(name = "mpesa_account_reference")

    private String mpesaAcountReference;
    @Column(name = "mpesa_stkpush_url")

    private String mpesaSTKPushUrl;
    @Column(name = "mpesa_stkpush_confirm_url")

    private String mpesaSTKConfirmUrl;
    @Column(name = "invalidate_session_data_after")

    private String invalidateSessionDataAfter;
    @Column(name = "scheme_phone_number")

    private String schemePhoneNumber;
    @Column(name = "scheme_email")
    private String schemeEmail;
    @Column(name = "minimum_enroll_age")
    private String minimumEnrollAge;
    @Column(name = "maximum_enroll_age")

    private String maximumEnrollAge;
    @Column(name = "minimum_withdrawal_amount")

    private String minimumWithdrawalAmount;
    @Column(name = "default_enroll_sponsor_id")
    private String defaultEnrollSponsorId;
    @Column(name = "welcome_screen_identifier")

    private String welcomeScreenIdentifier;
    @Column(name = "about_us_short_description")

    private String aboutUsShortDescription;
    @Column(name = "about_us_long_description")
    private String aboutUsLongDescription;
    @Column(name = "pension_name")
    private String pensionName;
    @Column(name = "pension_website")

    private String pensionWebsite;
    @Column(name = "pension_mobile_app_link")

    private String pensionMobileAppLink;
    @Column(name = "exist_ing_member_min_contribution")

    private String existingMemberMinContribution;
    @Column(name = "exist_ing_member_min_withdrawal")


    private String existingMemberMinWithdrawal;
    @Column(name = "enableOtp")

    private String enableOtp;
    @Column(name = "check_blocked_scheme")

    private String checkBlockedScheme;
}
