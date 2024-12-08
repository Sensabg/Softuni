package softuni.exam.readFile;
//TestVisitorServiceReadFromFile

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import softuni.exam.service.impl.VisitorServiceImpl;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestVisitorServiceReadFromFile {

    @Autowired
    private VisitorServiceImpl visitorService;

    @Test
    void readVisitorsFromFile() throws IOException {
        String expected = """
                <?xml version='1.0' encoding='UTF-8'?>
                <visitors>
                    <visitor>
                        <first_name>John</first_name>
                        <last_name>Smith</last_name>
                        <attraction_id>12</attraction_id>
                        <country_id>73</country_id>
                        <personal_data_id>61</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Smith</first_name>
                        <last_name>Johnson</last_name>
                        <attraction_id>10</attraction_id>
                        <country_id>83</country_id>
                        <personal_data_id>61</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Emma</first_name>
                        <last_name>Johnson</last_name>
                        <attraction_id>12</attraction_id>
                        <country_id>51</country_id>
                        <personal_data_id>62</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>James</first_name>
                        <last_name>Williams</last_name>
                        <attraction_id>29</attraction_id>
                        <country_id>87</country_id>
                        <personal_data_id>3</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>James</first_name>
                        <last_name>Williams</last_name>
                        <attraction_id>30</attraction_id>
                        <country_id>188</country_id>
                        <personal_data_id>69</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Sophia</first_name>
                        <last_name>Brown</last_name>
                        <attraction_id>45</attraction_id>
                        <country_id>76</country_id>
                        <personal_data_id>72</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Michael</first_name>
                        <last_name>Jones</last_name>
                        <attraction_id>21</attraction_id>
                        <country_id>18</country_id>
                        <personal_data_id>71</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Isabella</first_name>
                        <last_name>Garcia</last_name>
                        <attraction_id>2</attraction_id>
                        <country_id>123</country_id>
                        <personal_data_id>70</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>William</first_name>
                        <last_name>Miller</last_name>
                        <attraction_id>17</attraction_id>
                        <country_id>94</country_id>
                        <personal_data_id>51</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Olivia</first_name>
                        <last_name>Davis</last_name>
                        <attraction_id>9</attraction_id>
                        <country_id>11</country_id>
                        <personal_data_id>50</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>David</first_name>
                        <last_name>Martinez</last_name>
                        <attraction_id>36</attraction_id>
                        <country_id>172</country_id>
                        <personal_data_id>53</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Emily</first_name>
                        <last_name>Lopez</last_name>
                        <attraction_id>44</attraction_id>
                        <country_id>64</country_id>
                        <personal_data_id>52</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Christopher</first_name>
                        <last_name>Rodriguez</last_name>
                        <attraction_id>19</attraction_id>
                        <country_id>27</country_id>
                        <personal_data_id>65</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Abigail</first_name>
                        <last_name>Hernandez</last_name>
                        <attraction_id>11</attraction_id>
                        <country_id>32</country_id>
                        <personal_data_id>54</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Matthew</first_name>
                        <last_name>Wilson</last_name>
                        <attraction_id>33</attraction_id>
                        <country_id>119</country_id>
                        <personal_data_id>55</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Madison</first_name>
                        <last_name>Gonzalez</last_name>
                        <attraction_id>6</attraction_id>
                        <country_id>53</country_id>
                        <personal_data_id>56</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Daniel</first_name>
                        <last_name>Anderson</last_name>
                        <attraction_id>48</attraction_id>
                        <country_id>177</country_id>
                        <personal_data_id>59</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Ava</first_name>
                        <last_name>Thomas</last_name>
                        <attraction_id>40</attraction_id>
                        <country_id>79</country_id>
                        <personal_data_id>58</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Anthony</first_name>
                        <last_name>Taylor</last_name>
                        <attraction_id>26</attraction_id>
                        <country_id>34</country_id>
                        <personal_data_id>57</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Mia</first_name>
                        <last_name>Moore</last_name>
                        <attraction_id>18</attraction_id>
                        <country_id>56</country_id>
                        <personal_data_id>2</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Joshua</first_name>
                        <last_name>Jackson</last_name>
                        <attraction_id>31</attraction_id>
                        <country_id>108</country_id>
                        <personal_data_id>1</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Charlotte</first_name>
                        <last_name>Martin</last_name>
                        <attraction_id>47</attraction_id>
                        <country_id>96</country_id>
                        <personal_data_id>4</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Andrew</first_name>
                        <last_name>Lee</last_name>
                        <attraction_id>13</attraction_id>
                        <country_id>105</country_id>
                        <personal_data_id>47</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Amelia</first_name>
                        <last_name>Perez</last_name>
                        <attraction_id>37</attraction_id>
                        <country_id>21</country_id>
                        <personal_data_id>22</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Joseph</first_name>
                        <last_name>Thompson</last_name>
                        <attraction_id>4</attraction_id>
                        <country_id>180</country_id>
                        <personal_data_id>10</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Evelyn</first_name>
                        <last_name>White</last_name>
                        <attraction_id>15</attraction_id>
                        <country_id>68</country_id>
                        <personal_data_id>8</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Samuel</first_name>
                        <last_name>Harris</last_name>
                        <attraction_id>25</attraction_id>
                        <country_id>115</country_id>
                        <personal_data_id>9</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Sofia</first_name>
                        <last_name>Sanchez</last_name>
                        <attraction_id>14</attraction_id>
                        <country_id>49</country_id>
                        <personal_data_id>7</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Benjamin</first_name>
                        <last_name>Clark</last_name>
                        <attraction_id>38</attraction_id>
                        <country_id>166</country_id>
                        <personal_data_id>5</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Grace</first_name>
                        <last_name>Ramirez</last_name>
                        <attraction_id>16</attraction_id>
                        <country_id>134</country_id>
                        <personal_data_id>6</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Alexander</first_name>
                        <last_name>Lewis</last_name>
                        <attraction_id>46</attraction_id>
                        <country_id>71</country_id>
                        <personal_data_id>49</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Elizabeth</first_name>
                        <last_name>Robinson</last_name>
                        <attraction_id>28</attraction_id>
                        <country_id>41</country_id>
                        <personal_data_id>12</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Logan</first_name>
                        <last_name>Walker</last_name>
                        <attraction_id>22</attraction_id>
                        <country_id>158</country_id>
                        <personal_data_id>45</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Lily</first_name>
                        <last_name>Young</last_name>
                        <attraction_id>35</attraction_id>
                        <country_id>52</country_id>
                        <personal_data_id>32</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Henry</first_name>
                        <last_name>King</last_name>
                        <attraction_id>43</attraction_id>
                        <country_id>87</country_id>
                        <personal_data_id>21</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Ella</first_name>
                        <last_name>Scott</last_name>
                        <attraction_id>8</attraction_id>
                        <country_id>136</country_id>
                        <personal_data_id>20</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Ryan</first_name>
                        <last_name>Green</last_name>
                        <attraction_id>27</attraction_id>
                        <country_id>74</country_id>
                        <personal_data_id>29</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Victoria</first_name>
                        <last_name>Baker</last_name>
                        <attraction_id>10</attraction_id>
                        <country_id>123</country_id>
                        <personal_data_id>38</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Elijah</first_name>
                        <last_name>Adams</last_name>
                        <attraction_id>24</attraction_id>
                        <country_id>170</country_id>
                        <personal_data_id>23</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Scarlett</first_name>
                        <last_name>Nelson</last_name>
                        <attraction_id>7</attraction_id>
                        <country_id>29</country_id>
                        <personal_data_id>24</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Gabriel</first_name>
                        <last_name>Hill</last_name>
                        <attraction_id>20</attraction_id>
                        <country_id>182</country_id>
                        <personal_data_id>27</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Zoe</first_name>
                        <last_name>Carter</last_name>
                        <attraction_id>5</attraction_id>
                        <country_id>42</country_id>
                        <personal_data_id>28</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Jackson</first_name>
                        <last_name>Mitchell</last_name>
                        <attraction_id>42</attraction_id>
                        <country_id>63</country_id>
                        <personal_data_id>25</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Penelope</first_name>
                        <last_name>Perez</last_name>
                        <attraction_id>50</attraction_id>
                        <country_id>91</country_id>
                        <personal_data_id>26</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Lucas</first_name>
                        <last_name>Roberts</last_name>
                        <attraction_id>30</attraction_id>
                        <country_id>159</country_id>
                        <personal_data_id>31</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Chloe</first_name>
                        <last_name>Turner</last_name>
                        <attraction_id>41</attraction_id>
                        <country_id>114</country_id>
                        <personal_data_id>30</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Jack</first_name>
                        <last_name>Phillips</last_name>
                        <attraction_id>3</attraction_id>
                        <country_id>65</country_id>
                        <personal_data_id>33</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Harper</first_name>
                        <last_name>Campbell</last_name>
                        <attraction_id>23</attraction_id>
                        <country_id>138</country_id>
                        <personal_data_id>35</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Owen</first_name>
                        <last_name>Parker</last_name>
                        <attraction_id>32</attraction_id>
                        <country_id>120</country_id>
                        <personal_data_id>37</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Lillian</first_name>
                        <last_name>Evans</last_name>
                        <attraction_id>49</attraction_id>
                        <country_id>89</country_id>
                        <personal_data_id>36</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Thomas</first_name>
                        <last_name>Edwards</last_name>
                        <attraction_id>1</attraction_id>
                        <country_id>44</country_id>
                        <personal_data_id>39</personal_data_id>
                    </visitor>
                    <visitor>
                        <first_name>Hannah</first_name>
                        <last_name>Collins</last_name>
                        <attraction_id>39</attraction_id>
                        <country_id>152</country_id>
                        <personal_data_id>34</personal_data_id>
                    </visitor>
                </visitors>""";


        String actual = visitorService.readVisitorsFileContent()
                .replaceAll("\\r\\n|\\r|\\n", "\n").trim();;

        Assertions.assertEquals(expected, actual);
    }
}