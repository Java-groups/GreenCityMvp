package greencity.dto.category;

import greencity.constant.ServiceValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto implements Serializable {
    /**
     * Constructor.
     */
    public CategoryDto(
        @Pattern(regexp = "^[a-zA-Z0-9\\s][^<>]*$",
            message = ServiceValidationConstants.CATEGORY_NAME_BAD_FORMED) @Length(
                min = ServiceValidationConstants.CATEGORY_NAME_MIN_LENGTH,
                max = ServiceValidationConstants.CATEGORY_NAME_MAX_LENGTH) @NotBlank String name) {
        this.name = name;
    }

    @Pattern(regexp = "^[a-zA-Z0-9\\s][^<>]*$", message = ServiceValidationConstants.CATEGORY_NAME_BAD_FORMED)
    @Length(
        min = ServiceValidationConstants.CATEGORY_NAME_MIN_LENGTH,
        max = ServiceValidationConstants.CATEGORY_NAME_MAX_LENGTH)
    @NotBlank
    private String name;

    private String nameUa;

    private Long parentCategoryId;
}