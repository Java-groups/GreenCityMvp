package greencity.service;

import greencity.dto.PageableDto;
import greencity.dto.habit.HabitDto;
import greencity.dto.habit.HabitManagementDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ManagementHabitService {
    /**
     * Method finds {@code Habit} with all {@code HabitTranslation}'s by id.
     *
     * @param id {@code Habit} id.
     * @return {@link HabitManagementDto}.
     */
    HabitManagementDto getById(Long id);

    /**
     * Method finds all {@code Habit} with all {@code HabitTranslation}'s.
     *
     * @param pageable - instance of {@link Pageable}.
     * @return list of {@link HabitManagementDto}.
     * @author Dovganyuk Taras
     */
    PageableDto<HabitManagementDto> getAllHabitsDto(String searchReg, Integer durationFrom,
        Integer durationTo, Integer complexity, Boolean withoutImage,
        Boolean withImage,
        Pageable pageable);

    /**
     * Method saves {@code Habit} with it's {@code HabitTranslation}'s.
     *
     * @param habitManagementDto {@link HabitManagementDto}.
     * @param image              {@link MultipartFile} image for habit.
     * @return {@link HabitDto}.
     */
    HabitManagementDto saveHabitAndTranslations(HabitManagementDto habitManagementDto, MultipartFile image);

    /**
     * Method updates {@code Habit} instance.
     *
     * @param habitManagementDto - instance of {@link HabitManagementDto}.
     * @param image              {@link MultipartFile} image for habit.
     */
    void update(HabitManagementDto habitManagementDto, MultipartFile image);

    /**
     * Method deletes {@code Habit} instance by it's id.
     *
     * @param id {@code Habit} id.
     */
    void delete(Long id);

    /**
     * Method deletes all {@code Habit} instances by list of id's.
     *
     * @param listId list of {@code Habit} id's.
     */
    void deleteAll(List<Long> listId);
}
