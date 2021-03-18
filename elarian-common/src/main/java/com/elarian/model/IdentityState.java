package com.elarian.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IdentityState {
    List<Tag> tags = new ArrayList<>();
    Map<String, String> metadata = new HashMap<>();
    List<SecondaryId> secondaryIds = new ArrayList<>();
}
