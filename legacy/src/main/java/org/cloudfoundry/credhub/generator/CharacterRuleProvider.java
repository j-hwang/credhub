package org.cloudfoundry.credhub.generator;

import java.util.ArrayList;
import java.util.List;

import org.cloudfoundry.credhub.request.StringGenerationParameters;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;

final public class CharacterRuleProvider {

  private CharacterRuleProvider() {
    super();
  }

  public static List<CharacterRule> getCharacterRules(final StringGenerationParameters parameters) {
    final List<CharacterRule> characterRules = new ArrayList<>();

    if (parameters.isIncludeSpecial()) {
      characterRules.add(new CharacterRule(CredHubCharacterData.SPECIAL));
    }

    if (!parameters.isExcludeNumber()) {
      characterRules.add(new CharacterRule(EnglishCharacterData.Digit));
    }

    if (!parameters.isExcludeUpper()) {
      characterRules.add(new CharacterRule(EnglishCharacterData.UpperCase));
    }

    if (!parameters.isExcludeLower()) {
      characterRules.add(new CharacterRule(EnglishCharacterData.LowerCase));
    }

    return characterRules;
  }
}
